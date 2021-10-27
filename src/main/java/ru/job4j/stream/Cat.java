package ru.job4j.stream;

public class Cat {
    private String name;

    private byte age;

    private String breed;

    private String coatColor;

    private String eyeColor;

    private boolean sleepy;

    public static class Builder {
        private String name;
        private byte age;
        private String breed;
        private String coatColor;
        private String eyeColor;
        private boolean sleepy;

        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        public Builder buildBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder buildCoatColor(String coatColor) {
            this.coatColor = coatColor;
            return this;
        }

        public Builder buildEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder buildSleepy(boolean sleepy) {
            this.sleepy = sleepy;
            return this;
        }

        public Cat build() {
            Cat cat = new Cat();
            cat.name = name;
            cat.age = age;
            cat.breed = breed;
            cat.coatColor = coatColor;
            cat.eyeColor = eyeColor;
            cat.sleepy = sleepy;
            return cat;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", coatColor='" + coatColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", sleepy=" + sleepy +
                '}';
    }
}
