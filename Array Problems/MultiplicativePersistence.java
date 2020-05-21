class MultiplicativePersistence {
	public static int persistence(long n) {
  
  String s=n+"";
  int i=0,count=0,sum=1;
		while(s.trim().length()!=1){
    
      if(i==s.length()){
      count++;
      s=sum+"";
      sum=1;
      i=0;
      }else{
      sum*=Integer.parseInt(s.charAt(i)+"");
      i++;
      }
    }
    return count;
	}

    public static void main(String[] args) {
        System.out.println(persistence(39));
    }
}