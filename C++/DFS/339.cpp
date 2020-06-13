class Solution 
{
public:
    int depthSum(vector<NestedInteger>& nestedList, int height = 1) 
    {
        int sum = 0;
        for(auto& N : nestedList)
        {
            if(N.isInteger()) sum += (N.getInteger() * height);
            else sum  += depthSum(N.getList(), height+1);
        }
        return sum;
    }
};