package chapter_2;
/**
 * 【第2章---创建对象和销毁对象】
 * 2.遇到多个构造器参数时要考虑使用构建器
 *
 *    使用内部类  减少代码跨类处理
 * */
public class NutritionFactss {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder{
        @Override
        public String toString() {
            return "Builder{" +
                    "servingSize=" + servingSize +
                    ", servings=" + servings +
                    ", calories=" + calories +
                    ", fat=" + fat +
                    ", carbohydrate=" + carbohydrate +
                    ", sodium=" + sodium +
                    '}';
        }

        // required parameters
        private final int servingSize;
        private final int servings;
        // optional parameters
        private int calories =0;
        private int fat=0;
        private int carbohydrate=0;
        private int sodium=0;

        public Builder(int servingSize,int servings){
            this.servingSize=servingSize;
            this.servings=servings;
        }

        public Builder calories(int val){
           calories=val; return this;
        }

        public Builder fat(int val){
            fat=val; return this;
        }

        public Builder carbohydrate(int val){
            carbohydrate=val; return this;
        }

        public Builder sodium(int val){
            sodium=val; return this;
        }

        public NutritionFactss build(){
            return new NutritionFactss(this);
        }

    }
    private NutritionFactss(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }


    public static void main(String[] args) {
        NutritionFactss nutritionFactss = new Builder(240,8).
                calories(100).sodium(35).carbohydrate(20).fat(100).build();
        System.out.println(nutritionFactss.toString());
        System.out.println(nutritionFactss.servings+nutritionFactss.fat+nutritionFactss.carbohydrate);
    }


}
