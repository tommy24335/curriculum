
public class Check{
  public static void main(String[] args){
      /*
      * 問1
      * int型の配列dataを作成し、値を3,1,2,7,5で初期化しなさい
      */
        int[] data = {3, 1, 2, 7, 5};
      /*
      * 問2
      * 以下のfor文を完成させなさい
      */
      for(int i = 0; i < 5; i++){
          System.out.print(data[i] + " ");
      }
      System.out.println();
      for (int i = 0; i < data.length - 1; i++) {
        //外側のループは左端にくる小さな数字を確定させていくループ
        //ループ変数iは0,1,2,3 = ４回ループが繰り返される
        //配列の要素数−１回のループが必要
          for (int j = data.length - 1; j > i; j--) {
            //隣り合う要素を比較
              /*
              * 問3
              * 以下、配列の添字を入れてソートを完成させなさい
              */
              if(data[j-1] > data[j]){  //隣り合う要素の大小判定
                int box = data[j];
                data[j] = data[j-1];
                data[j-1] = box;
              }
          }
      }
      for(int i = 0; i < data.length; i++){
          System.out.print(data[i] + " ");
      }
      System.out.println();
  }
}