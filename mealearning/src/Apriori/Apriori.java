package Apriori;

import java.util.*;
import java.io.*;
public class Apriori {
	static double min_support = 0.5;
	static double min_confident = 0.7;
	//�ļ�·�����ҵ����ڵ�ǰ��Ŀ�£���һ����Լ����ļ�·��������
	static String filePath = "c://666.txt";
	static ArrayList<ArrayList<String>> D = new ArrayList<ArrayList<String>>();//�������ݿ�D
	static HashMap<ArrayList<String>, Integer> C = new HashMap<ArrayList<String>, Integer>();//��Ŀ��C
	static HashMap<ArrayList<String>, Integer> L = new HashMap<ArrayList<String>, Integer>();//��ѡ��L
	// ���ڴ�ȡ��ѡ��ÿ�μ���������������е�Ƶ���L����������������򣬾Ͳ����ٴα����������ݿ⡣
	static HashMap<ArrayList<String>, Integer> L_ALL = new HashMap<ArrayList<String>, Integer>();
	//���ļ��ж�ȡ����,��������
	public static ArrayList<ArrayList<String>> readTable(String filePath){
		ArrayList<ArrayList<String>> t = new ArrayList<ArrayList<String>>();
		ArrayList<String> t1 = null;
		File file = new File(filePath);
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(isr);
			String str = null;
			while((str = bf.readLine()) != null) {
				t1 = new ArrayList<String>();
				String[] str1 = str.split(" ");
				for(int i = 0; i < str1.length ; i++) {
					t1.add(str1[i]);
				}
				t.add(t1);
			}
			bf.close();
			isr.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ļ������ڣ�");
		}
		System.out.println("\nD:"+t);
		return t;
	}
	
	//��֦�����Ӻ�ѡ��C��ɾ��С����С֧�ֶȵģ�������Ƶ����L��
	public static void pruning(HashMap<ArrayList<String>, Integer> C,HashMap<ArrayList<String>, 
			Integer> L) {
		L.clear();
		// ������Ŀ�����ɺ�ѡ��
		L.putAll(C);
		// ɾ��������С֧�ֶȵ�Ԫ��
		ArrayList<ArrayList<String>> delete_key = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> key : L.keySet()) {
			if (L.get(key) < min_support) {
				delete_key.add(key);
			}
		}
		for (int i = 0; i < delete_key.size(); i++) {
			L.remove(delete_key.get(i));
		}
	}
 
	/**
	 * ��ʼ���������ݿ⡢��Ŀ������ѡ��
	 */
	public static void init() {
		//���ļ��е����ݷ��뼯��D��
		D = readTable(filePath);
		// ɨ���������ݿ⡣������Ŀ����֧�ֶ�=��Ԫ�����������ݿ���ֵĴ���/�������ݿ��������
		for (int i = 0; i < D.size(); i++) {
			for (int j = 0; j < D.get(i).size(); j++) {
				String[] e = { D.get(i).get(j) };
				//������eת��ΪList
				ArrayList<String> item = new ArrayList<String>(Arrays.asList(e));
				//map���Ƿ����ָ���ļ�
				if (!C.containsKey(item)) {
					C.put(item, 1);
					//System.out.println(C.get(item));
				} else {
					C.put(item, C.get(item) + 1);
					//System.out.println(C.get(item));
				}
			}
		}
		//System.out.println("D.size= "+D.size());
		pruning(C, L);// ��֦
		//��Ƶ������뼯����
		L_ALL.putAll(L);
	}
 
	// �����������󲢼�
	public static ArrayList<String> arrayListUnion(ArrayList<String> arraylist1, ArrayList<String> arraylist2) {
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.addAll(arraylist1);
		arraylist.addAll(arraylist2);
		//��ArrayListת��ΪHashSetȥ���ظ�Ԫ�أ��ٽ�HashSetת��ΪArrayList
		arraylist = new ArrayList<String>(new HashSet<String>(arraylist));
		return arraylist;
	}
 
	/**
	 * ����������յĺ�ѡƵ����
	 * 
	 * @param C
	 *            ��ɳ�ʼ������Ŀ��
	 * @param L
	 *            ��ɳ�ʼ���ĺ�ѡ��
	 * @return ���յĺ�ѡƵ����
	 */
	public static HashMap<ArrayList<String>, Integer> iteration(HashMap<ArrayList<String>, Integer> C,HashMap<ArrayList<String>, Integer> L) {
		HashMap<ArrayList<String>, Integer> L_temp = new HashMap<ArrayList<String>, Integer>();// �����ж��Ƿ������֦����ʱ����
		String str = null;
		int t = 1;// ��������
		while (L.size() > 0) {// һ������֦����ɾ�����֦֮ǰ��������Ҫ��Ľ����
			t++;
			L_temp.clear();
			L_temp.putAll(L);
			// һ�����Ӳ�
			C.clear();
			// 1.��L�е�����һ���Ĺ�������ƥ��
			ArrayList<ArrayList<String>> L_key = new ArrayList<ArrayList<String>>(L.keySet());
			for (int i = 0; i < L_key.size(); i++) {
				for (int j = i + 1; j < L_key.size(); j++) {
					ArrayList<String> C_item = new ArrayList<String>();
					C_item = new ArrayList<String>(arrayListUnion(L_key.get(i),
							L_key.get(j)));
					if (C_item.size() == t) {
						C.put(C_item, 0);// Ƶ��������зǿ��Ӽ���������Ƶ����
					}
				}
			}
			// 2.ͨ��ɨ��D����������֧�ֶ�
			for (ArrayList<String> key : C.keySet()) {
				for (int i = 0; i < D.size(); i++) {
					if (D.get(i).containsAll(key)) {
						C.put(key, C.get(key) + 1 );
					}
				}
			}
			str = C.toString();
			
			 System.out.println("��ѡ"+t+"���C: \n"+C);
			// ������֦��
			pruning(C, L);
			 System.out.println("Ƶ��"+t+"���L: \n"+L+"\n");
			 str = L.toString();
			 
			 //System.out.println("===");
			L_ALL.putAll(L);
		}
		return L_temp;
	}
 
	// ��һ�����ϵ������Ӽ�
	public static ArrayList<ArrayList<String>> getSubset(ArrayList<String> L) {
		if (L.size() > 0) {
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < Math.pow(2, L.size()); i++) {// �����Ӽ�����=2�ĸü��ϳ��ȵĳ˷�
				ArrayList<String> subSet = new ArrayList<String>();
				int index = i;// ������0һֱ��2�ļ��ϳ��ȵĳ˷�-1
				for (int j = 0; j < L.size(); j++) {
					// ͨ����һλ�ƣ��ж�������һλ��1������ǣ�����Ӵ���
					if ((index & 1) == 1) {// λ�����㣬�ж����һλ�Ƿ�Ϊ1
						subSet.add(L.get(j));
					}
					index >>= 1;// ��������һλ
				}
				result.add(subSet); // ���Ӽ��洢����
			}
			return result;
		} else {
			return null;
		}
	}
 
	// �ж����������ཻ�Ƿ�Ϊ��
	public static boolean intersectionIsNull(ArrayList<String> l1,
			ArrayList<String> l2) {
		Set<String> s1 = new HashSet<String>(l1);
		Set<String> s2 = new HashSet<String>(l2);
 
		s1.retainAll(s2);
		if (s1.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
 
	/**
	 * �������յĹ����������ݹ�ʽ��������������¼�
	 */
	public static void connection() {
		for (ArrayList<String> key : L_ALL.keySet()) {// �����յĹ����������¼������ж�
			ArrayList<ArrayList<String>> key_allSubset = getSubset(key);
			//�õ�����Ƶ������ÿ�����ϵ��Ӽ�
			// System.out.println(key_allSubset);
			for (int i = 0; i < key_allSubset.size(); i++) {
				ArrayList<String> item_pre = key_allSubset.get(i);//�õ�һ�����Ӽ�
				if (0 < item_pre.size() && item_pre.size() < key.size()) {// �ж��Ƿ��Ƿǿ����Ӽ�
					// �����ǿջ������Ӽ�֮���γɹ����¼�
					double item_pre_support = L_ALL.get(item_pre);//�õ����Ӽ���֧�ֶȶ�
					//System.out.println("itempre="+item_pre_support);
					for (int j = 0; j < key_allSubset.size(); j++) {
						ArrayList<String> item_post = key_allSubset.get(j);
						if (0 < item_post.size()
								&& item_post.size() < key.size()
								&& arrayListUnion(item_pre, item_post).equals(key)
								&& intersectionIsNull(item_pre, item_post))
						//���ཻ�������ǿ����Ӽ����ಢΪƵ���
						{
							double d = L_ALL.get(arrayListUnion(item_pre, item_post));
							//double item_post_support = L_ALL.get(item_post);// �������Ӽ���֧�ֶȱ������¼������Ŷ�
							//System.out.println("item_post="+item_post_support);
							double confident = d
									/ item_pre_support; // �¼������Ŷ�
							if (confident > min_confident) {// ����¼������Ŷȴ�����С���Ŷ�
								System.out.print(item_pre + "==>" + item_post );// ����һ�������¼�
								System.out.println("==>" + confident);
							}
						}
 
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Apriori apriori = new Apriori();
        apriori.init();
        System.out.println("��ѡ1���C��\n"+apriori.C); 
        System.out.println("Ƶ��1���L��\n"+apriori.L+"\n");
        apriori.L = apriori.iteration(apriori.C, apriori.L);
        System.out.println("�����������£�");
        apriori.connection();
	}
}

