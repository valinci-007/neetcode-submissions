/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Map<Node, Node> newRef = new HashMap<>();

        while(!q.isEmpty()){
            Node oldNode = q.poll();
            Node newNode = new Node(oldNode.val);

            newRef.put(oldNode, newNode);

            for(Node nei : oldNode.neighbors){
                if(!newRef.containsKey(nei)) 
                    q.offer(nei);
            }
        }

        for(Map.Entry<Node, Node> entry : newRef.entrySet()){
            Node oldNode = entry.getKey();
            Node newNode = entry.getValue();

            List<Node> newNei = new ArrayList<>();
            for(Node nei : oldNode.neighbors){
                newNei.add(newRef.get(nei));
            }

            newNode.neighbors = newNei;
        }

        return newRef.get(node);
    }
}