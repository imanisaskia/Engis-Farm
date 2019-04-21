package farm_products;

/**
 * Kelas ChickenEgg terdiri dari atribut tipe dan harga.
 * Kelas ChickenEgg digunakan untuk menginstansiasi objek ChickenEgg.
 * @author Lydia Astrella Wiguna (13517019)
 */
public class ChickenEgg extends FarmProduct{
        private int type;   /*ChickenEgg type = 1*/
        private int price;  /*ChickenEgg price*/

        /** constructor*/
        public ChickenEgg(){
			type =1;
			price =5;
		}

        /** return ChickenEgg type*/
        public int getType(){
			return type;
		}

        /** return ChickenEgg price*/
        public int getPrice(){
			return price;
		}
}

