# Portainer

Username: admin
Password: admin123

A képen azt látni, hogy mik magának a host-nak a paraméterei (pl. CPU, RAM), valamint, hogy mik a docker futási paraméterei.
![Alt text](image.png)

A portainer IP címe 172.18.0.2, a 172.18.0.2:9000-es címen is elértük a portainert.

Network:
- None: Ez nem éri el a külvilágot
- host: közvetlenül a hostOs hálózatát éri el
- bridge: köztes réteg a konténerek és a host között.Emiatt lehet konténereknek saját IP címe.
- portainer_default: Ez a portainer hálózata, ami bridge-t használ

Hello-world:
- Látszanak a környezeti változók
- A CMD amivel indult
- IP cím
- Mikor indult
- logs: konténer belső console-ja kiírva
- stats: konténer által használt erőforrások grafikonjai

Advanced settings:
- CMD and logging: Beállítható a parancs amivel indítva van, valamint a logolás típusa
- Volumes: A perzisztens adatok állíthatók be
- Network: Itt állíthatóak be a hálózati beállítások
- Env: Környezeti változók szerkeszthetőek
- Labels: Különböző címkéket lehet rárakni ami hasznos üzemeltetésnél
- Restart-policy: Itt lehet beállítani, hogy mikor induljon újra. Itt állítottuk be "Unless-stopeed"-ra
- Runtime & Resources: Beállíthatóak, hogy mennyi eroforrast kaphat max a konténer
- capabilities: különböző jogosultságok adhatóak

![Alt text](image-1.png)

![Alt text](image-2.png)

Wordpress:
- a vloume-ok miatt maradt meg

![Alt text](image-3.png)
![Alt text](image-4.png)

A volume törlés után az adatok elvesztek.

![Alt text](image-5.png)

Minikube:

- minden előtt a RAM total 3919,5MB, used 1800MB
- 2 node van, ebből a minukube a controle a ROLES alapján
  - Ezzel a 2 nodeal több fut a portaineren is

![Alt text](image-6.png)

- A minikube futtatás után 2014MB-ot használunk

Nem működött a portainerbe csatolás, mivel a minikube hálózat a minikube tagja

Cluster:
- Node-ok
- health checkek ereménye
- RAM és CPU használat

ugyan azon az információk érhetőek el róla, mint egy docker konténerről

- Active, azaz elérhető a hálózatban.
- A pauseban a kluster része, de uj feladatot nem kap
- A drain pedig amikor az összes rajta futó pod-ot eltávolítja

Applications:
![Alt text](image-7.png)

PHP-guestbook:

Deployment: Biztosítja a futást, Service: Hálózati elérhetőség

![Alt text](image-8.png)

Ez egy alap html page. Ezt kéne kapnunk az oldalat megkeresve.

Ugyan az volt a válasz a test app-on is
![Alt text](image-9.png)

Mindkét IP-vel elértük a service-nek köszönhetően:
![Alt text](image-10.png)
![Alt text](image-11.png)

Loadbaalnce:
![Alt text](image-12.png)

Ingress:
![Alt text](image-13.png)

Scaling:

3 lett, ebből 2 fut,1 vár. Ami eddig futott az most is fut
![Alt text](image-14.png)
![Alt text](image-15.png)
![Alt text](image-16.png)


Configuration:
![Alt text](image-17.png)

Persistance:
- abban más, hogy a shared-nél minden replica ugyan azt látja
 - shared: DB, isolated: ideiglenes adatok (pl. munkamenet)

 ![Alt text](image-18.png)
 ![Alt text](image-19.png)

 Redeploy után minden megmaradt:
 ![Alt text](image-20.png)

 Átállítás után hiba lett:
 ![Alt text](image-21.png)

 Visszaváltás után ujra jó:
 ![Alt text](image-22.png)

 NFS:

 Megmaradt:
 ![Alt text](image-23.png)

 A másik node-on is megmaradt:
 ![Alt text](image-24.png)

 Megmaradt:
 ![Alt text](image-25.png)
Azért mert egy nfs konténerbe tároljuk az adatokat, nem pedig konténerenként, ezért ha új nodeot indítunk akkor a podba felmásolja az adatokat.

