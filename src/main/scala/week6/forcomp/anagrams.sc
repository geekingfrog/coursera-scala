import forcomp.Anagrams._

object anagrams {

  val w = "bOnjour"                               //> w  : java.lang.String = bOnjour

  val tmp = (w.toLowerCase groupBy (el => el) map (e => (e._1, e._2.length)) toList) sorted
                                                  //> tmp  : List[(Char, Int)] = List((b,1), (j,1), (n,1), (o,2), (r,1), (u,1))

  val x = wordOccurrences("lard")                 //> x  : forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1), (r,1))
  val y = wordOccurrences("r")                    //> y  : forcomp.Anagrams.Occurrences = List((r,1))
  
  def getOcc(list: List[(Char,Int)])(c: Char) =
    list.foldLeft(0)((acc,curr)=>
    if(c==curr._1) curr._2
    else acc)                                     //> getOcc: (list: List[(Char, Int)])(c: Char)Int
     
  val s = List("yes","man")                       //> s  : List[java.lang.String] = List(yes, man)
   
  (for(x <- 1 to 2) yield List(x)).toList.flatten //> res0: List[Int] = List(1, 2)
}