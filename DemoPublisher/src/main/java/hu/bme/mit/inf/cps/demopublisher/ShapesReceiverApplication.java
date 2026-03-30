package hu.bme.mit.inf.cps.demopublisher;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.*;
import com.rti.dds.publication.DataWriterQos;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.*;
import com.rti.dds.topic.Topic;
import hu.bme.mit.inf.cps.demopublisher.shape.*;

public class ShapesReceiverApplication {
    private static final int DOMAIN_ID = 0;

    private static final String SQUARE_TOPIC = "Square";
    private static final String CIRCLE_TOPIC = "Circle";
    private static final String TRIANGLE_TOPIC = "Triangle";

    private static ShapeTypeDataReader squareReader;

    public static void main(String[] args) {
        final DomainParticipant participant = DomainParticipantFactory.TheParticipantFactory.create_participant(
                DOMAIN_ID, DomainParticipantFactory.PARTICIPANT_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final Subscriber subscriber = participant.create_subscriber(
                DomainParticipant.SUBSCRIBER_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final String typeName = ShapeTypeTypeSupport.get_type_name();
        ShapeTypeTypeSupport.register_type(participant, typeName);

        final Topic squareTopic = participant.create_topic(
                SQUARE_TOPIC, typeName, DomainParticipant.TOPIC_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final DataReaderQos squareQos = new DataReaderQos();
        participant.get_default_datareader_qos(squareQos);
        squareQos.reliability.kind = ReliabilityQosPolicyKind.BEST_EFFORT_RELIABILITY_QOS;
        squareQos.durability.kind = DurabilityQosPolicyKind.VOLATILE_DURABILITY_QOS;
        squareQos.history.kind = HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS;
        squareQos.history.depth = 1;

        squareReader = (ShapeTypeDataReader) subscriber.create_datareader(
                squareTopic, squareQos,
                new DataReaderAdapter() {
                    @Override
                    public void on_data_available(final DataReader reader) {
                        final ShapeTypeDataReader squareReader = (ShapeTypeDataReader) reader;

                        final ShapeTypeSeq shapeTypeSeq = new ShapeTypeSeq();
                        final SampleInfoSeq sampleInfoSeq = new SampleInfoSeq();

                        System.out.println("Read");
                        squareReader.read(shapeTypeSeq, sampleInfoSeq,
                                ResourceLimitsQosPolicy.LENGTH_UNLIMITED,
                                SampleStateKind.ANY_SAMPLE_STATE,
                                ViewStateKind.ANY_VIEW_STATE,
                                InstanceStateKind.ANY_INSTANCE_STATE
                        );

                        System.out.println("# of samples: " + shapeTypeSeq.size());
                        for(final Object obj : shapeTypeSeq) {
                            final ShapeType shape = (ShapeType) obj;

                            System.out.printf("%dx%d %s%n", shape.x, shape.y, shape.color);
                        }
                    }

                    @Override
                    public void on_sample_lost(DataReader reader, SampleLostStatus status) {
                        System.out.println("Sample lost");
                    }

                    @Override
                    public void on_subscription_matched(DataReader reader, SubscriptionMatchedStatus status) {
                        System.out.println("Sample lost");
                    }

                    @Override
                    public void on_requested_incompatible_qos(DataReader reader, RequestedIncompatibleQosStatus status) {
                        System.out.println("Incompatible qos");
                    }

                }, StatusKind.STATUS_MASK_ALL
        );
    }


}
