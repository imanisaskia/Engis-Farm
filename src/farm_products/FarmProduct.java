package farm_products;

/**
 * Kelas FarmProduct merupakan kelas abstrak yang memiliki 2 method abstrak getter untuk kelas turunannya.
 * Method getType digunakan untuk mendapatkan tipe dan method getPrice digunakan untuk mendapatkan harga.
 * @author Lydia Astrella Wiguna (13517019)
 */
abstract public class FarmProduct{
   
        /**abstract function to get FarmProduct type*/
        public abstract int getType();

        /**abstract function to get FarmProduct price*/
        public abstract int getPrice();
}

