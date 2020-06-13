class Solution 
{    
public:
    vector<int> getLonelyNodes(TreeNode* root) 
    {
        vector<int> result;
        stack<TreeNode*> stack;
        
        if(root != nullptr) stack.push(root);
        
        while(!stack.empty())
        {
            auto top = stack.top(); stack.pop();
            if(top->left == nullptr && top->right != nullptr)
            {
                result.push_back(top->right->val);
                stack.push(top->right);
            }
            else if(top->right == nullptr && top->left != nullptr)
            {
                result.push_back(top->left->val);
                stack.push(top->left);
            }
            else if(top->left != nullptr && top->right != nullptr)
            {
                stack.push(top->right);
                stack.push(top->left);
            }
        }
        return result;
    }
};