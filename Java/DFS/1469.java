class Solution 
{
    public List<Integer> getLonelyNodes(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root != null) stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode top = stack.pop();
            if(top.left == null && top.right != null)
            {
                result.add(top.right.val);
                stack.push(top.right);
            }
            else if(top.right == null && top.left != null)
            {
                result.add(top.left.val);
                stack.push(top.left);
            }
            else if(top.left != null && top.right != null)
            {
                stack.push(top.right);
                stack.push(top.left);
            }
        }
        return result;
    }
}