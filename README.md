# Alkfejl
## 1.1 Célkitűzés
#### A cél egy edzőterem csoportos óráinak meghirdetése, a dolgozóknak lehetősége lesz az egyes órák meghirdetésére, időponttal és az oktató nevével feltüntetve. A vendégeknek lehetősége lesz fizetésre, és az órák lefoglalására.
## 1.2. Funkcionális követelmények
1.	Regisztráció
2.	Bejelentkezés
3.	Bejelentkezett vendégeknek:
    - Bérlet vásárlása
    -	Az órákra hely foglalása
    - Kérdések feltétele
4.	Bejelentkezett oktatóknak:
    -	Órák listázása
    -	Órák meghirdetése
    - Órák törlése
    - Órák adatainak módosítása
## 1.3.	Nem funkcionális követelmények
1.	Gyors működés.
2.	Könnyű használhatóság. 
3.	Gyors adatelérés.
4.	Jól navigálható oldal.
5.	Biztonságos, jelszóval védett oldal (legalább 10 karakter, nagybetűt és számot is kell tartalmaznia).
## 1.4. Szakterületi fogalomjegyzék
1.	órarend: a csoportos órák feltüntetve az oktató nevével, a teremmel, és az időponttal
## 1.5. Szerepkörök
1.	Látogató: Nem regisztrált látogató.
2.	Oktató: Regisztrált, belépés után órákat tud meghirdetni, illetve módosítani ezek adatait
3.	Vendég: Regisztrált, belépés után órákra foglalhat helyet, illetve törölheti azt

## 2.1 Végpont-tervek és leírások
   - POST
     - login
     - register
     - reserveprocess - felejelentkezés órára
     - newlesson - új csoportos óra meghirdetése
  - GET
    - lessons - meghirdetett csoportos órák listázása
 - PUT
   - modifylesson - csoportos óra szerkesztése
 - DELETE
   - deletelesson - csoportos óra törlése
# Fejlesztői környezet
## Felhasznált eszözök
  - Github verziókezelő
  - NetBeans IDE
  - SpringBoot Java keretrendszer
  - H2 adatbázis kezelő
## Projekt indítása
### Backend
  - Git telepítése
  - Projekt klónozása:https://github.com/iamzolii/Alkfejl
  - A használt fejlesztői környezetbe való importálás után a Spring alkalmazás indítása lehetséges:
     - ha elérhető Maven plug-in, akkor a run goal futtatásával
     - parancssorból: mvn spring-boot:run 
# Alkalmazott könyvtárstruktúra
   - controller
      - LessonController.java
      - LoginController.java
      - MemberShipController.java
      - RegistrationController.java
   - dao
      - LessonDao.java
      - LessonImpl.java
      - UserDao.java
      - UseImpl.java
   - model
      - Lesson.java
      - Lessons.java
      - Login.java
      - Membership.java
      - Privileges.java
      - User.java
   - service
      - LessonService.java
      - LessonServiceImpl.java
      - UserService.java
      - UserServiceImpl.java
   - UserServiceTest.java
   
