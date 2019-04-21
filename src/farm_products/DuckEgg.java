package farm_products;

/**
 * Kelas DuckEgg terdiri dari atribut tipe dan harga.
 * Kelas DuckEgg digunakan untuk menginstansiasi objek DuckEgg.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class DuckEgg extends FarmProduct{
        private int type;   /*DuckEgg type = 2*/
        private int price;  /*DuckEgg price*/

        /**constructor */
        public DuckEgg(){
			type =2;
			price =7;
		}

        /**return DuckEgg type*/
        public int getType(){
			return type;
		}

        /**return DuckEgg price*/
        public int getPrice(){
			return price;
		}
}


