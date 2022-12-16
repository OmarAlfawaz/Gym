package system;

public class progress {

        int rips, sits, weight;
        String muscle;

        public progress() {
            this.rips = 0;
            this.sits = 0;
            this.weight = 0;
            this.muscle = "";
        }

        public progress(int rips, int sits, int weight, String muscle) {
            this.rips = rips;
            this.sits = sits;
            this.weight = weight;
            this.muscle = muscle;

        }
        public void setRips(int rips) {
            this.rips = rips;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setSits(int sits) {
            this.sits = sits;
        }

        public void setMuscle(String muscle) {
            this.muscle = muscle;
        }

        public int getRips() {
            return rips;
        }

        public int getWeight() {
            return weight;
        }

        public String getMuscle() {
            return muscle;
        }

        @Override
        public String toString() {
            return "progress{" +
                    "rips=" + rips +
                    ", sits=" + sits +
                    ", weight=" + weight +
                    ", muscle='" + muscle + '\'' +
                    '}';
        }
    }


