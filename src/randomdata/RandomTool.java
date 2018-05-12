package randomdata;
import java.util.Random;

public class RandomTool {
	Random rd=new Random(System.currentTimeMillis());
	private String[] fuhao={",","。","!","?"};
	private String[] chenghu={
			"兄弟","我的天","是吧","你","不过","可是","但是","走过去","动动脑子","楼主",
			"别","可","天啦噜","阿西吧","我曹","哈哈哈哈","呵呵呵","恩。。","。。","来吧",
			"我发现","我觉得","我是说","我以为","你这","我这","谢谢","对不起","不客气","多谢了",
			"我我我","激动ing","怎么了","退一万步","哎","啊","呵呵","我去","咳咳","你你你",
	};

	// private String chenshuju={};
	public String Randomfuhao() {
		int haha = Randomnum(1, 4);
		String result = fuhao[haha-1];

		return result;
	}
	public String Randomchenghu() {
		int haha = Randomnum(1, 40);
		String result = chenghu[haha-1];

		return result;
	}	
	public int Randomnum(int a,int b){
		int result=a;
		
		result=a+rd.nextInt(b-a+1);;
		return result;
		
	}
	public String Randomname(int seed){
		
		char tmp='a';
		int length=Randomnum(3,8);
		String result="";
		for(int i=0;i<length;i++){
		tmp=(char)('a'+(seed+i+Randomnum(3,8))%26);
			result+=tmp;
			
		}
		return result;
		
		
	}
	/*public String Randomsentence(){}*/
	public int RandomDate(){
		int y=Randomnum(90,99),m=Randomnum(1,12),d=Randomnum(1,28);
		
		
		return y*10000+m*100+d;
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		RandomTool rdt=new RandomTool();
		/*for(int i=0;i<=100;i++){
			System.out.print(rdt.Randomnum(4, 9)+"  ");
			
		}*/
		
		/*
		for(int i=0;i<=10;i++){
			System.out.println(rdt.RandomDate());
		}*/
		

		/*for(int i=0;i<=10;i++){
			System.out.println(rdt.Randomname(i));
		}*/
	}

}
