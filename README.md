# Kütüphane Demo

Spring, Thymeleaf, JPA, Maven ve MySQL kullanarak yapılmış basit bir kütüphane uygulaması.

### Kurulum

Kodları indirdikten sonra kullandığınız ide üzerinde maven projesi importu yaparak çalıştırabilirsiniz.

MySQL ayarlarını kendime göre ayarladığım için bazı ayarları değiştirmeniz gerekebilir.

Öncelikle bir MySQL veritabanı oluşturulmalıdır. Resources içindeki application.properties dosyasındaki ilgili veritabanı ayarlarını kendinize göre düzenlemelisiniz.

```sh
spring.datasource.url=jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
```

Yukarıdaki kısımda library yazan yere kendi oluşturduğunuz veritabanı ismini yazmalısınız. Ben library ismiyle oluşturduğum için bu şekilde yazdım.

Ayrıca aşağıdaki satırları da aynı şekilde kendinize göre değiştirmelisiniz.

```sh
spring.datasource.username=root
spring.datasource.password=password
```

Son olarak da ana dizindeki pom.xml dosyasında msql-connector-java kısmında kendi kullandığım versiyon var. Bunun bir etkisi olur mu emin değilim ama versiyon ile ilgili bir hata olursa bu da aklınızda bulunsun.

```sh
        <dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>8.0.22</version>
		</dependency>
```
