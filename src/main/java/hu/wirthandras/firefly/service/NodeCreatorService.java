package hu.wirthandras.firefly.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import hu.wirthandras.firefly.domain.Node;

@Service
public class NodeCreatorService {
	
	private static final int BOUND = 100;
	
	public int randomId() {
		Random r = new Random();
		return r.nextInt(BOUND);
	} 

	public Node makeANode(String id) {
		Node n = new Node();
		long idAsNumber = Long.parseLong(id);
		n.setName("Node " + id);
		n.setId(idAsNumber);
		Random r = new Random();
		Node p = makeParent(r);
		n.setParent(p);
		List<Node> children = makeChildren(n, r);
		n.setChildren(children);
		return n;
	}

	private Node makeParent(Random r) {
		Node p = new Node();
		long pid = Integer.toUnsignedLong(r.nextInt(100));
		p.setId(pid);
		return p;
	}

	private List<Node> makeChildren(Node n, Random r) {
		List<Node> children = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Node c = new Node();
			long cid = Integer.toUnsignedLong(r.nextInt(100));
			c.setName("Child " + cid);
			c.setParent(n);
			c.setId(cid);
			children.add(c);
		}
		return children;
	}
}
