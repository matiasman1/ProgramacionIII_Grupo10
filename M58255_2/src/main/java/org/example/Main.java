package org.example;
import org.example.entidades.*;
import org.example.repositorios.InMemoryRepository;
import java.time.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Articulo> articuloRepository = new InMemoryRepository<>();
        InMemoryRepository<Promocion> promocionRepository = new InMemoryRepository<>();

        //crear las unidades de medida
        UnidadMedida porcion8 = UnidadMedida.builder().id(1L).denominacion("8 Porciones").build();
        UnidadMedida porcion4 = UnidadMedida.builder().id(2L).denominacion("4 Porciones").build();
        UnidadMedida litro1 = UnidadMedida.builder().id(3L).denominacion("1 Litro").build();

        // crear imagenes
        // Pizzas
        Imagen imagen1 = Imagen.builder().id(1L).denominacion("Pizza grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().id(2L).denominacion("Pizza grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().id(3L).denominacion("Pizza grande Muzza").build();
        Imagen imagen4 = Imagen.builder().id(4L).denominacion("Pizza chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().id(5L).denominacion("Pizza chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().id(6L).denominacion("Pizza chica Muzza").build();

        // Cervezas
        Imagen imagen7 = Imagen.builder().id(7L).denominacion("Cerveza Andes").build();
        Imagen imagen8 = Imagen.builder().id(8L).denominacion("Cerveza Quilmes").build();

        // Promociones
        Imagen imahappy1 = Imagen.builder().id(9L).denominacion("Promo Happy Hour 1").build();
        Imagen imahappy2 = Imagen.builder().id(10L).denominacion("Promo Happy Hour 2").build();
        Imagen verano1 = Imagen.builder().id(11L).denominacion("Promo Verano 1").build();
        Imagen verano2 = Imagen.builder().id(12L).denominacion("Promo Verano 2").build();
        Imagen invierno1 = Imagen.builder().id(13L).denominacion("Promo Invierno 1").build();
        Imagen invierno2 = Imagen.builder().id(14L).denominacion("Promo Invierno 2").build();

        // crear articulos
        // Pizzas
        Articulo pizzaGrandeHawaiana = Articulo.builder().id(1L).denominacion("Pizza grande Hawaiana").precioVenta(500.0).precioCompra(350.0).stockActual(10).stockMaximo(50).imagen(imagen1).unidadMedida(porcion8).build();
        Articulo pizzaChicaHawaiana = Articulo.builder().id(2L).denominacion("Pizza chica Hawaiana").precioVenta(300.0).precioCompra(200.0).stockActual(15).stockMaximo(50).imagen(imagen4).unidadMedida(porcion4).build();
        Articulo pizzaGrandeNapolitana = Articulo.builder().id(3L).denominacion("Pizza grande Napolitana").precioVenta(550.0).precioCompra(370.0).stockActual(10).stockMaximo(50).imagen(imagen2).unidadMedida(porcion8).build();
        Articulo pizzaChicaNapolitana = Articulo.builder().id(4L).denominacion("Pizza chica Napolitana").precioVenta(320.0).precioCompra(220.0).stockActual(12).stockMaximo(50).imagen(imagen5).unidadMedida(porcion4).build();
        Articulo pizzaGrandeMuzza = Articulo.builder().id(5L).denominacion("Pizza grande Muzza").precioVenta(480.0).precioCompra(300.0).stockActual(8).stockMaximo(50).imagen(imagen3).unidadMedida(porcion8).build();
        Articulo pizzaChicaMuzza = Articulo.builder().id(6L).denominacion("Pizza chica Muzza").precioVenta(280.0).precioCompra(180.0).stockActual(15).stockMaximo(50).imagen(imagen6).unidadMedida(porcion4).build();

        // Cervezas
        Articulo cervezaAndes = Articulo.builder().id(7L).denominacion("Cerveza Andes").precioVenta(200.0).precioCompra(100.0).stockActual(30).stockMaximo(100).imagen(imagen7).unidadMedida(litro1).build();
        Articulo cervezaQuilmes = Articulo.builder().id(8L).denominacion("Cerveza Quilmes").precioVenta(220.0).precioCompra(110.0).stockActual(25).stockMaximo(100).imagen(imagen8).unidadMedida(litro1).build();

        // Guardar articulos
        articuloRepository.save(pizzaGrandeHawaiana);
        articuloRepository.save(pizzaChicaHawaiana);
        articuloRepository.save(pizzaGrandeNapolitana);
        articuloRepository.save(pizzaChicaNapolitana);
        articuloRepository.save(pizzaGrandeMuzza);
        articuloRepository.save(pizzaChicaMuzza);
        articuloRepository.save(cervezaAndes);
        articuloRepository.save(cervezaQuilmes);

        // crear promociones

        Promocion happyHourPromo = Promocion.builder()
                .id(1L)
                .denominacion("Happy Hour")
                .FechaDesde(LocalDate.of(2024, 9, 1))
                .FechaHasta(LocalDate.of(2024, 9, 30))
                .HoraDesde(LocalTime.of(18, 0))
                .HoraHasta(LocalTime.of(20, 0))
                .descripcionDescuento("Descuento de Happy Hour")
                .precioPromocional(900.0)
                .TipoPromocion(TipoPromocion.HAPPY_HOUR)
                .promoImagen(imahappy1)
                .articulos(Set.of(pizzaGrandeHawaiana, pizzaGrandeMuzza, cervezaQuilmes))
                .build();

        Promocion veranoPromo = Promocion.builder()
                .id(2L)
                .denominacion("Verano")
                .FechaDesde(LocalDate.of(2024, 12, 1))
                .FechaHasta(LocalDate.of(2024, 12, 31))
                .HoraDesde(LocalTime.of(12, 0))
                .HoraHasta(LocalTime.of(14, 0))
                .descripcionDescuento("Descuento de Verano")
                .precioPromocional(1000.0)
                .TipoPromocion(TipoPromocion.VERANO)
                .promoImagen(verano1)
                .articulos(Set.of(pizzaChicaHawaiana, pizzaGrandeNapolitana, cervezaQuilmes, cervezaAndes))
                .build();

        Promocion inviernoPromo = Promocion.builder()
                .id(3L)
                .denominacion("Invierno")
                .FechaDesde(LocalDate.of(2024, 6, 1))
                .FechaHasta(LocalDate.of(2024, 6, 30))
                .HoraDesde(LocalTime.of(19, 0))
                .HoraHasta(LocalTime.of(21, 0))
                .descripcionDescuento("Descuento de Invierno")
                .precioPromocional(850.0)
                .TipoPromocion(TipoPromocion.INVIERNO)
                .promoImagen(invierno1)
                .articulos(Set.of(pizzaGrandeHawaiana, pizzaChicaMuzza, cervezaQuilmes))
                .build();

        // Guardar promociones
        promocionRepository.save(happyHourPromo);
        promocionRepository.save(veranoPromo);
        promocionRepository.save(inviernoPromo);

        // a. Mostrar todas las promociones
        System.out.println("Todas las promociones:");
        List<Promocion> todasLasPromociones = promocionRepository.findAll();
        todasLasPromociones.forEach(System.out::println);

        // b. Mostrar todos los Artículos
        System.out.println("Todos los Artículos:");
        List<Articulo> todosLosArticulos = articuloRepository.findAll();
        todosLosArticulos.forEach(System.out::println);

        // c. Mostrar cada promoción con artículos y precio de venta
        todasLasPromociones.forEach(promo -> {
            System.out.println("Promoción: " + promo.getDenominacion());
            System.out.println("Precio: "+ promo.getPrecioPromocional());
            System.out.println("Artículos:");
            promo.getArticulos().forEach(art -> {
                System.out.println("- " + art.getDenominacion() + " - Precio Venta: $" + art.getPrecioVenta());
            });
            System.out.println(); // Adds a blank line after each promotion for better readability
        });

        // d. Mostrar el día y horario de la promoción Verano
        List<Promocion> promocionesVerano = promocionRepository.genericFindByField("denominacion", "Verano");
        if (!promocionesVerano.isEmpty()) {
            Promocion promoVerano = promocionesVerano.get(0);
            System.out.println("Promoción Verano está activa del " + promoVerano.getFechaDesde() + " al " + promoVerano.getFechaHasta() +
                    " desde las " + promoVerano.getHoraDesde() + " hasta las " + promoVerano.getHoraHasta());
        } else {
            System.out.println("No se encontró la promoción Verano.");
        }

        // e. Mostrar cuál es la promoción más económica de las 3
        List<Promocion> allPromotions = promocionRepository.findAll();
        Promocion cheapestPromotion = allPromotions.stream()
                .min(Comparator.comparing(Promocion::getPrecioPromocional))
                .orElse(null);

        if (cheapestPromotion != null) {
            System.out.println("La promoción más económica es: " + cheapestPromotion.getDenominacion() +
                    " con un precio de " + cheapestPromotion.getPrecioPromocional());
        }
    }
}