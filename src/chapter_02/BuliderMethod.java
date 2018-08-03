package chapter_02;


/**
 * 【第2章---创建对象和销毁对象】
 * 2.遇到多个构造器参数时要考虑使用构建器
 *
 *    使用内部类  减少代码跨类处理
 * */


public class BuliderMethod {



    /** --------------------多个构造器 start-------------------------------  */

    //内部类
    public class NutritionFacts{

        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrate;

        public NutritionFacts(int servingSize,int servings){
            this(servingSize,servings,0);
        }

        public NutritionFacts(
                int servingSize,
                int servings,
                int calories
        ){
            this(servingSize,servings,calories,0);
        }

        public NutritionFacts(
                int servingSize,
                int servings,
                int calories,
                int fat
        ){
            this(servingSize,servings,calories,fat,0);
        }


        public NutritionFacts(
                int servingSize,
                int servings,
                int calories,
                int fat,
                int sodium
        ){
            this(servingSize,servings,
                    calories,fat,sodium,0);
        }

        public NutritionFacts(
                int servingSize,
                int servings,
                int calories,
                int fat,
                int sodium,
                int carbohydrate
        ){
            this.servingSize=servingSize;
            this.servings=servings;
            this.calories=calories;
            this.fat=fat;
            this.sodium=sodium;
            this.carbohydrate=carbohydrate;
        }
    }


    /** --------------------多个构造器 end-------------------------------  */




    /**
     * 当你想要创建是咧的时候，就利用参数列表最短的构造器
     *
     * 但该列表包含了要设置的所有参数
     * */





    /**
     *
     *上述的方案可以改造成下面的方案  JavaBean方式
     *
     * */


    public class NutritionFactsss{

        private  int servingSize=-1;
        private  int servings=-1;
        private  int calories=0;
        private  int fat=0;
        private  int sodium=0;
        private  int carbohydrate=0;


        public void setServingSize(int val) {
            servingSize = val;
        }

        public void setServings(int servings) {
            this.servings = servings;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public void setFat(int fat) {
            this.fat = fat;
        }

        public void setSodium(int sodium) {
            this.sodium = sodium;
        }

        public void setCarbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        //无参构造方法  默认可以不写
        public NutritionFactsss(){ }

    }






    /**
     *
     *上述的方案可以改造成下面的方案  JavaBean方式
     *
     * 其优缺点具体参考 effective java   P11-12
     *
     * 优点：容易创建对象实例
     * 缺点: 使用Javabean可能导致对象状态处于不一致性  额外能力保证线程安全
     *
     * */



    /**
     *
     *上述的方案可以改造成下面的方案  Builder方式  详见 类  NutritionFactss
     *
     *
     * */







    public static void main(String[] args) {

        //实例化内部类
        //1.首先实例化外部类
        BuliderMethod buliderMethod = new BuliderMethod();
        //2.把内部类当成一个成员变量进行实例化  有参数的构造方法
        NutritionFacts Nu = buliderMethod.new NutritionFacts(11,22,33,0,55,44);


        //实例化内部类  Javabean
        BuliderMethod buliderMethods = new BuliderMethod();
        //NutritionFactss nutritionFactss = new NutritionFactss();
        NutritionFactsss nutritionFactss = buliderMethods.new NutritionFactsss();
        nutritionFactss.setCalories(1);


        //builder模式
        NutritionFactss nutritionFacts = new NutritionFactss.Builder(240,8).
                calories(100).sodium(35).carbohydrate(20).fat(100).build();
        System.out.println(nutritionFactss.servings+nutritionFactss.fat+nutritionFactss.carbohydrate);

    }


}
