package cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.domain;

public class Flower {
        private Integer pk_FlowerId;
        private String nameFlower;
        private String countryFlower;

        public Flower() {
        }

        public Flower(Integer pk_FlowerId, String nameFlower, String countryFlower) {
            this.nameFlower = nameFlower;
            this.countryFlower = countryFlower;
        }

        public Integer getPk_FlowerId() {
            return pk_FlowerId;
        }

        public void setPk_FlowerId(Integer pk_FlowerId) {
            this.pk_FlowerId = pk_FlowerId;
        }

        public String getNameFlower() {
            return nameFlower;
        }

        public void setNameFlower(String nameFlower) {
            this.nameFlower = nameFlower;
        }

        public String getCountryFlower() {
            return countryFlower;
        }

        public void setCountryFlower(String countryFlower) {
            this.countryFlower = countryFlower;
        }
}
