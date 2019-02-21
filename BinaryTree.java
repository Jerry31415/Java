import java.util.ArrayList;

final public class BinaryTree{
	private class Node {
		Node L;
		Node R;
		Integer value;
	}
	
	private Node tree;
	private ArrayList<Integer> sorted;
	
	private Integer minNodeValue(Node node) {
		return (node.L!=null)?minNodeValue(node.L):node.value; 
	}
	
	private Integer maxNodeValue(Node node) {
		return (node.R!=null)?maxNodeValue(node.R):node.value; 
	}
	
	private void sortNodes(Node node) {
		if(node.L!=null) {
			sortNodes(node.L);
		}
		sorted.add(node.value);
		if(node.R!=null) {
			sortNodes(node.R);
		}
	}
		
	private void insert(Node node, Integer elem) {
		if(elem<node.value) {
			if(node.L==null) {
				node.L = new Node();
				node.L.value = elem;
				return;
			}
			insert(node.L, elem);
		}
		else {
			if(node.R==null) {
				node.R = new Node();
				node.R.value = elem;
				return;
			}
			insert(node.R, elem);
		}
	}
	
	/**
	 * Создает новый экземпляр бинарного дерева
	 * @param arr - массив целых чисел
	 * */
	public BinaryTree(Integer[] arr) {
		tree = new Node();
		tree.value = arr[0];
		for(int i=1;i<arr.length;++i) {
			insert(tree, arr[i]);
		}
	}

	/**
	 * Возвращает минимальный элемент дерева
	 * */
	public Integer min() {
		return minNodeValue(tree);
	}
		
	/**
	 * Возвращает максимальный элемент дерева
	 * */
	public Integer max() {
		return maxNodeValue(tree);
	}
	
	/**
	 * Производит обход бинарного дерева.
	 * @return Возвращает сортированный контейнер
	 * */
	public ArrayList<Integer> sort() {
		sorted = new ArrayList<Integer>();
		sortNodes(tree);
		return sorted;
	}
	
}
