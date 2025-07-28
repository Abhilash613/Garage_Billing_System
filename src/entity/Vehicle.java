
package entity;

    public class Vehicle {
        private int id;
        private String number;
        private String model;
        private int customerId;

        public Vehicle() {
        }

        public Vehicle(String number, String model, int customerId) {
            this.number = number;
            this.model = model;
            this.customerId = customerId;
        }

        public Vehicle(int id, String number, String model, int customerId) {
            this.id = id;
            this.number = number;
            this.model = model;
            this.customerId = customerId;
        }

        // Getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        @Override
        public String toString() {
            return "[ Vehicle id = " + id + ", number = " + number +
                    ", model = " + model + ", customerId = " + customerId + " ]";
        }
    }
