package by.epam.course.string.asarray;

/*
    Преобразовывает имена переменных из camelCase в snake_case
 */

public class StringAsArray1 {

    public static boolean isLowerCase(char ch){
        return ch>='a'&&ch<='z';
    }

    public static char toLowerCase(char ch){
        if(ch>='A'&&ch<='Z'){
            ch-='A'-'a';
        }
        return ch;
    }

    public static boolean isDigit(char ch){
        return ch>='1'&&ch<='9';
    }

    public static String[] fromCamelToSnakeCase(String[] strings){
        String buff=new String();
        for(int i=0;i<strings.length;i++){
            for(int j=0;j<strings[i].length();j++){
                if(isLowerCase(strings[i].charAt(j))||isDigit(strings[i].charAt(j))){
                    buff+=strings[i].charAt(j);
                }else{
                    buff+='_';
                    buff+=toLowerCase(strings[i].charAt(j));
                }
            }
            strings[i]=buff;
            buff="";
        }

        return strings;
    }

    public static void main(String[] args) {
        String name1="myName";
        String name2="oneDay";
        String name3="testOfWorkOfMyApp";

        String[] nameOfVar={name1,name2,name3};
        fromCamelToSnakeCase(nameOfVar);

        for(int i=0;i<nameOfVar.length;i++){
           System.out.print(nameOfVar[i]+"  ");
        }
    }
}
