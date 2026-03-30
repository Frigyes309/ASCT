package hu.bme.mit.inf.cps.demopublisher;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.*;
import com.rti.dds.publication.DataWriterQos;
import com.rti.dds.publication.Publisher;
import com.rti.dds.topic.Topic;
import hu.bme.mit.inf.cps.demopublisher.shape.ShapeType;
import hu.bme.mit.inf.cps.demopublisher.shape.ShapeTypeDataWriter;
import hu.bme.mit.inf.cps.demopublisher.shape.ShapeTypeTypeSupport;

public class ShapesApplication {
    private static final int DOMAIN_ID = 0;

    private static final String SQUARE_TOPIC = "Square";
    private static final String CIRCLE_TOPIC = "Circle";
    private static final String TRIANGLE_TOPIC = "Triangle";

    private static ShapeTypeDataWriter squareWriter;
    private static ShapeTypeDataWriter circleWriter;

    public static void main(String[] args) {
        initDDS();

        final Thread squareThread = new Thread(ShapesApplication::squarePublish);
        squareThread.start();
        final Thread circleThread = new Thread(ShapesApplication::circlePublish);
        circleThread.start();

        try {
            squareThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final int SQUARE_CENTER_X = 125;
    private static final int SQUARE_CENTER_Y = 125;
    private static final int SQUARE_RADIUS = 50;

    private static void squarePublish() {
        int t = 0;
        while(true) {
            final ShapeType shape = new ShapeType();
            shape.x = (int) (SQUARE_CENTER_X + SQUARE_RADIUS * Math.cos(t/10.0));
            shape.y = (int) (SQUARE_CENTER_Y + SQUARE_RADIUS * Math.sin(t/10.0));
            shape.color = "BLUE";
            shape.shapesize = 20;

            squareWriter.write(shape, InstanceHandle_t.HANDLE_NIL);

            try {
                t++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void circlePublish() {
        int t = 0;
        int side = 100;
        int startX = 75;
        int startY = 75;

        while(true) {
            final ShapeType shape = new ShapeType();
            shape.color = "RED";
            shape.shapesize = 30;

            int progress = t % 400;

            if (progress < 100) {
                shape.x = startX + progress;
                shape.y = startY;
            } else if (progress < 200) {
                shape.x = startX + side;
                shape.y = startY + (progress - 100);
            } else if (progress < 300) {
                shape.x = startX + side - (progress - 200);
                shape.y = startY + side;
            } else {
                shape.x = startX;
                shape.y = startY + side - (progress - 300);
            }

            circleWriter.write(shape, InstanceHandle_t.HANDLE_NIL);

            try {
                t += 5;
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void initDDS() {
        final DomainParticipant participant = DomainParticipantFactory.TheParticipantFactory.create_participant(
                DOMAIN_ID, DomainParticipantFactory.PARTICIPANT_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final Publisher publisher = participant.create_publisher(
                DomainParticipant.PUBLISHER_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final String typeName = ShapeTypeTypeSupport.get_type_name();
        ShapeTypeTypeSupport.register_type(participant, typeName);

        final Topic squareTopic = participant.create_topic(
                SQUARE_TOPIC, typeName, DomainParticipant.TOPIC_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final DataWriterQos squareQos = new DataWriterQos();
        participant.get_default_datawriter_qos(squareQos);

        squareWriter = (ShapeTypeDataWriter) publisher.create_datawriter(
                squareTopic, squareQos,
                null, StatusKind.STATUS_MASK_NONE
        );

        final Topic circleTopic = participant.create_topic(
                CIRCLE_TOPIC, typeName, DomainParticipant.TOPIC_QOS_DEFAULT,
                null, StatusKind.STATUS_MASK_NONE
        );

        final DataWriterQos circleQos = new DataWriterQos();
        participant.get_default_datawriter_qos(circleQos);

        circleWriter = (ShapeTypeDataWriter) publisher.create_datawriter(
                circleTopic, circleQos,
                null, StatusKind.STATUS_MASK_NONE
        );
    }
}