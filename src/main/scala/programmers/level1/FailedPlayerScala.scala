package codetest.programmers.level1

object FailedPlayerScala {

  def main(args : Array[String]): Unit = {
    val completion = Array("1", "2", "3", "4", "5", "6", "7", "8", "9");
    val participant = Array("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    println("## Result : " + recursion (participant, completion, 0));
  }

  def recursion(participant : Array[String], completion : Array[String], index : Int) : String = {
    if (completion.length == index) {
      return participant(index);
    }

    println("## Index : " + index);

    val isSame = participant(index).contentEquals(completion(index));
    //throw new Exception
    if (index.equals(7)) throw new Exception else recursion(participant, completion, index + 1);
    //if (isSame) recursion(participant, completion, index + 1)  else participant(index);
  }


}
