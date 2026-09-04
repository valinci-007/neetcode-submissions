public class Codec {

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");

        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    int idx = 0;

    private TreeNode build(String[] arr) {

        if (arr[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }

    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");

        idx = 0;

        return build(arr);
    }
}