package cc.shinbi.shindan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	private List<Result> results;
	private List<Question> questions;
	
	private Shindan() {
		this.results = new ArrayList<Result>();
		this.questions = new ArrayList<Question>();
	}
	
	public List<Result> getResults(){
		return results;
	}
	
	public List<Question> getQuestions(){
		return questions;
	}
	
	public void shuffle() {
		for(Question question: this.questions) {
			question.shuffle();
		}
		Collections.shuffle(this.questions);
	}
	
	private static List<Result> getResultList(){
		Result[] results = {
				new Result(
					"しろくま",
					"あなたは北から逃げてきた寒がりで人見知りな「しろくま」タイプです。"
						),
				new Result(
						"ぺんぎん？",
						"あなたは自分はペンギン？なのか自信がない「ぺんぎん？」タイプです。"
							),
				new Result(
						"とんかつ",
						"あなたは脂っぽくて食べ残された「とんかつ」タイプです。"
							),
				new Result(
						"ねこ",
						"あなたは恥ずかしがりやで気が弱い「ねこ」タイプです。"
							)
				};
		
		List<Result> list =Arrays.asList(results);
		return list;
		}
	
	private static List<Question> getQuestionList(){
		List<Question> list = new ArrayList<Question>();
		
		Question question1 = new Question("q1","好きな食べ物は？");
		question1.addItems(0, "特にない");
		question1.addItems(1,"きゅうり");
		question1.addItems(2,"とんかつ");
		question1.addItems(3,"魚");
		list.add(question1);
		

		Question question2 = new Question("q2","あなたの性格は？");
		question2.addItems(0, "マイペース");
		question2.addItems(1,"自分に自信がない");
		question2.addItems(2,"落ち込みやすい");
		question2.addItems(3,"謙虚");
		list.add(question2);
		

		Question question3 = new Question("q3","好きなことは？");
		question3.addItems(0, "温泉旅");
		question3.addItems(1,"読書");
		question3.addItems(2,"ぼーっとする");
		question3.addItems(3,"お金の管理");
		list.add(question3);
		

		Question question4 = new Question("q4","好きな動物は？");
		question4.addItems(0, "くま");
		question4.addItems(1,"ぺんぎん");
		question4.addItems(2,"えび");
		question4.addItems(3,"ねこ");
		list.add(question4);
		

		Question question5 = new Question("q5","もし「隅っこ」があったらどんな行動をする？");
		question5.addItems(0, "すみっこでマイペースにお茶を飲む");
		question5.addItems(1,"すみっこを占拠するためにずるい手を使う");
		question5.addItems(2,"とりあえずほかの周りの動きを見る");
		question5.addItems(3,"他の人が来たらすぐにゆずる");
		list.add(question5);
		
		return list;
		}
	
	public static Shindan createShindan() {
		Shindan shindan = new Shindan();
		
		List<Result> results = getResultList();
		shindan.getResults().addAll(results);
		
		List<Question> questions=getQuestionList();
		shindan.getQuestions().addAll(questions);
		
		shindan.shuffle();
		
		return shindan;
	}
	
	public Result check(List<Integer> answers) {
		int[] counters = new int[this.results.size()];
		Arrays.fill(counters, 0);
		
		for(Integer index : answers) {
			counters[index]++;
		}
		
		int index = 0;
		int maxCount = 0;
		for(int i = 0; i< counters.length; i++) {
			int counter = counters[i];
			if(counter > maxCount) {
				index = i;
				maxCount = counter;
			}
		}
		
		return this.results.get(index);
	}

}
