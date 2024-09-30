
package org.example;

import org.example.entidades.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager em = emf.createEntityManager();
        System.out.println("en marcha Alberto");

        try {

            em.getTransaction().begin();

            UnidadMedida porciones8 = UnidadMedida.builder()
                    .denominacion("8 Porciones")
                    .build();

            UnidadMedida porciones4 = UnidadMedida.builder()
                    .denominacion("4 Porciones")
                    .build();

            UnidadMedida litro = UnidadMedida.builder()
                    .denominacion("1 Litro")
                    .build();

            // Persist these in the database
            em.persist(porciones8);
            em.persist(porciones4);
            em.persist(litro);

            em.getTransaction().commit();

            em.getTransaction().begin();

            Imagen imagen1 = Imagen.builder().name("Pizza grande Hawaiana").url("image1.jpg").build();
            Imagen imagen2 = Imagen.builder().name("Pizza grande Napolitana").url("image2.jpg").build();
            Imagen imagen3 = Imagen.builder().name("Pizza grande Muzza").url("image3.jpg").build();
            Imagen imagen4 = Imagen.builder().name("Pizza chica Hawaiana").url("image4.jpg").build();
            Imagen imagen5 = Imagen.builder().name("Pizza chica Napolitana").url("image5.jpg").build();
            Imagen imagen6 = Imagen.builder().name("Pizza chica Muzza").url("image6.jpg").build();
            Imagen imagen7 = Imagen.builder().name("Cerveza Andes").url("image7.jpg").build();
            Imagen imagen8 = Imagen.builder().name("Cerveza Quilmes").url("image8.jpg").build();

            Imagen imahappy1 = Imagen.builder().name("Promoción Happy Hour 1").url("imahappy1.jpg").build();
            Imagen imahappy2 = Imagen.builder().name("Promoción Happy Hour 2").url("imahappy2.jpg").build();
            Imagen verano1 = Imagen.builder().name("Promoción Verano 1").url("verano1.jpg").build();
            Imagen verano2 = Imagen.builder().name("Promoción Verano 2").url("verano2.jpg").build();
            Imagen invierno1 = Imagen.builder().name("Promoción Invierno 1").url("invierno1.jpg").build();
            Imagen invierno2 = Imagen.builder().name("Promoción Invierno 2").url("invierno2.jpg").build();

// Persist these images
            em.persist(imagen1);
            em.persist(imagen2);
            em.persist(imagen3);
            em.persist(imagen4);
            em.persist(imagen5);
            em.persist(imagen6);
            em.persist(imagen7);
            em.persist(imagen8);

            em.persist(imahappy1);
            em.persist(imahappy2);
            em.persist(verano1);
            em.persist(verano2);
            em.persist(invierno1);
            em.persist(invierno2);

            em.getTransaction().commit();

            em.getTransaction().begin();

            Articulo pizzaGrandeHawaiana = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana")
                    .precioVenta(1200.0)
                    .codigo("PIZZA-G-HAWA")
                    .imagen(imagen1)
                    .unidadMedida(porciones8)
                    .build();

            Articulo pizzaChicaHawaiana = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana")
                    .precioVenta(900.0)
                    .codigo("PIZZA-C-HAWA")
                    .imagen(imagen4)
                    .unidadMedida(porciones4)
                    .build();

            Articulo pizzaGrandeNapolitana = Articulo.builder()
                    .denominacion("Pizza grande Napolitana")
                    .precioVenta(1150.0)
                    .codigo("PIZZA-G-NAPO")
                    .imagen(imagen2)
                    .unidadMedida(porciones8)
                    .build();

            Articulo pizzaChicaNapolitana = Articulo.builder()
                    .denominacion("Pizza chica Napolitana")
                    .precioVenta(850.0)
                    .codigo("PIZZA-C-NAPO")
                    .imagen(imagen5)
                    .unidadMedida(porciones4)
                    .build();

            Articulo pizzaGrandeMuzza = Articulo.builder()
                    .denominacion("Pizza grande Muzza")
                    .precioVenta(1100.0)
                    .codigo("PIZZA-G-MUZZA")
                    .imagen(imagen3)
                    .unidadMedida(porciones8)
                    .build();

            Articulo pizzaChicaMuzza = Articulo.builder()
                    .denominacion("Pizza chica Muzza")
                    .precioVenta(800.0)
                    .codigo("PIZZA-C-MUZZA")
                    .imagen(imagen6)
                    .unidadMedida(porciones4)
                    .build();

            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .precioVenta(300.0)
                    .codigo("CERVEZA-ANDES")
                    .imagen(imagen7)
                    .unidadMedida(litro)
                    .build();

            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .precioVenta(280.0)
                    .codigo("CERVEZA-QUILMES")
                    .imagen(imagen8)
                    .unidadMedida(litro)
                    .build();

// Persist these articles
            em.persist(pizzaGrandeHawaiana);
            em.persist(pizzaChicaHawaiana);
            em.persist(pizzaGrandeNapolitana);
            em.persist(pizzaChicaNapolitana);
            em.persist(pizzaGrandeMuzza);
            em.persist(pizzaChicaMuzza);
            em.persist(cervezaAndes);
            em.persist(cervezaQuilmes);

            em.getTransaction().commit();

            em.getTransaction().begin();

            Promocion happyHour = Promocion.builder()
                    .denominacion("Happy Hour")
                    .fechaDesde(LocalDate.of(2024, 9, 1))
                    .fechaHasta(LocalDate.of(2024, 9, 30))
                    .horaDesde(LocalTime.of(18, 0))
                    .horaHasta(LocalTime.of(20, 0))
                    .descripcionDescuento("Descuento especial en pizzas y cervezas")
                    .precioPromocional(500.0)
                    .tipoPromocion(TipoPromocion.happyHour)
                    .articulos(Set.of(pizzaGrandeHawaiana, pizzaGrandeMuzza, cervezaQuilmes))
                    .promoImagen(Set.of(imahappy1, imahappy2))
                    .build();

// Persist the Happy Hour promotion
            em.persist(happyHour);

            em.getTransaction().commit();

            em.getTransaction().begin();

            Promocion verano = Promocion.builder()
                    .denominacion("Verano")
                    .fechaDesde(LocalDate.of(2024, 12, 1))
                    .fechaHasta(LocalDate.of(2024, 12, 31))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(14, 0))
                    .descripcionDescuento("Promoción especial de verano")
                    .precioPromocional(600.0)
                    .tipoPromocion(TipoPromocion.Verano)
                    .articulos(Set.of(pizzaChicaHawaiana, pizzaGrandeNapolitana, cervezaQuilmes, cervezaAndes))
                    .promoImagen(Set.of(verano1, verano2))
                    .build();

// Persist the Verano promotion
            em.persist(verano);

            em.getTransaction().commit();

            em.getTransaction().begin();

            Promocion invierno = Promocion.builder()
                    .denominacion("Invierno")
                    .fechaDesde(LocalDate.of(2024, 6, 1))
                    .fechaHasta(LocalDate.of(2024, 6, 30))
                    .horaDesde(LocalTime.of(12, 0))
                    .horaHasta(LocalTime.of(14, 0))
                    .descripcionDescuento("Promoción especial de invierno")
                    .precioPromocional(550.0)
                    .tipoPromocion(TipoPromocion.Invierno)
                    .articulos(Set.of(pizzaGrandeHawaiana, pizzaChicaMuzza, cervezaQuilmes))
                    .promoImagen(Set.of(invierno1, invierno2))
                    .build();

// Persist the Invierno promotion
            em.persist(invierno);

            em.getTransaction().commit();

            em.getTransaction().begin();

            // Query para todas las promociones
            List<Promocion> promociones = em.createQuery("SELECT p FROM Promocion p", Promocion.class).getResultList();

            // Display
            for (Promocion promocion : promociones) {
                System.out.println(promocion);
            }

            em.getTransaction().commit();

            em.getTransaction().begin();

            // Query para todos los articulos
            List<Articulo> articulos = em.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();

            // Display
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }

            em.getTransaction().commit();

            em.getTransaction().begin();

            for (Promocion promocion : promociones) {
                System.out.println("Promoción: " + promocion.getDenominacion());
                System.out.println("Descripción: " + promocion.getDescripcionDescuento());
                System.out.println("Precio Promocional: " + promocion.getPrecioPromocional());
                System.out.println("Artículos relacionados:");

                for (Articulo articulo : promocion.getArticulos()) {
                    System.out.println(" - " + articulo.getDenominacion() + ": " + articulo.getPrecioVenta());
                }

                System.out.println();
            }

            em.getTransaction().commit();

            em.getTransaction().begin();

            System.out.println("Promoción: " + verano.getDenominacion());
            System.out.println("Fecha Desde: " + verano.getFechaDesde());
            System.out.println("Fecha Hasta: " + verano.getFechaHasta());
            System.out.println("Hora Desde: " + verano.getHoraDesde());
            System.out.println("Hora Hasta: " + verano.getHoraHasta());

            em.getTransaction().commit();

            em.getTransaction().begin();


            // Encuentra la promocion mas economica
            Promocion promoMasEconomica = promociones.stream()
                    .min(Comparator.comparing(Promocion::getPrecioPromocional))
                    .orElse(null);

            if (promoMasEconomica != null) {
                System.out.println("La promoción más económica es: " + promoMasEconomica.getDenominacion());
                System.out.println("Precio Promocional: " + promoMasEconomica.getPrecioPromocional());
            }

            em.getTransaction().commit();

        }catch (Exception e){

            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Salí por el catch");}

        // Cerrar el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}

/*

Manejo del Ciclo de Estados en JPA
El ciclo de estados en JPA (Java Persistence API) define los diferentes estados que puede tener una entidad en relación con el contexto de persistencia (EntityManager). Comprender y manejar correctamente estos estados es crucial para trabajar eficazmente con JPA. Los estados del ciclo de vida de una entidad en JPA son:

New (Nuevo):

Una entidad está en estado "New" cuando ha sido creada pero aún no ha sido persistida en la base de datos.
Managed (Gestionado):

Una entidad está en estado "Managed" cuando está asociada con un contexto de persistencia (EntityManager) y cualquier cambio en la entidad se reflejará automáticamente en la base de datos.
Detached (Desconectado):

Una entidad está en estado "Detached" cuando ya no está asociada con un contexto de persistencia. Los cambios en la entidad no se reflejarán automáticamente en la base de datos.
Removed (Eliminado):

Una entidad está en estado "Removed" cuando ha sido marcada para su eliminación en la base de datos.
*/


