class Solution 
{
    private int getDepthSum(NestedInteger N, int height)
    {
        if(N.isInteger()) return N.getInteger() * height;
        int sum = 0;
        for(NestedInteger child : N.getList())
        {
            sum += getDepthSum(child, height+1);
        }
        return sum;
    }
    
    public int depthSum(List<NestedInteger> nestedList) 
    {
        int sum = 0;
        for(NestedInteger n : nestedList)
        {
            sum += getDepthSum(n, 1);
        }
        return sum;
    }
}