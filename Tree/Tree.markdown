# 树

## 二叉树

### 遍历

- 深度优先遍历
    - 前序遍历：先访问根节点，再前序遍历左子树，再前序遍历右子树
    - 中序遍历：先中序遍历左子树，再访问根节点，再中序遍历右子树
    - 后序遍历：先后序遍历左子树，再后序遍历右子树，再访问根节点
- 广度优先遍历
    - 层次遍历
- 存储结构
    - 链表存储
    - 数组存储
```
二叉树的遍历

输入: [1,2,3,null,null,4]
    1
  /   \
 2     3
      /
     4   
输出: 
前序遍历：  [1,2,3,4]
中序遍历：  [2,1,4,3]
后序遍历：  [2,4,3,1]
```

#### 递归遍历
```java
class Traversal{

    public List<Integer>  traversal(TreeNode root){
        ArrayList<Integer> integers = new ArrayList<>();
        traversal(root, integers);
        return integers;
    }

    private void traversal(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return;
        }
        // 前序遍历 
        // integers.add(root.val);
        traversal(root.left, integers);
        // 中序遍历
        // integers.add(root.val);
        traversal(root.right, integers);
        // 后序遍历
        // integers.add(root.val);
    }
}
    
```

#### 迭代遍历
##### 1. 前序遍历

```java
class Traversal{
    // 迭代算法前序遍历  宽度优先， 从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return integers;
        s.add(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            integers.add(node.val);
            if (node.right != null) {
                s.add(node.right);
            }
            if (node.left != null) {
                s.add(node.left);
            }
        }
        return integers;
    }
    // 迭代法前序遍历2  深度优先，
    public List<Integer> preTraversal(TreeNode root){
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                integers.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return integers;
    }
}
```
##### 2. 中序遍历
```java
class Traversal{
    // 迭代算法中序遍历   深度优先
    public List<Integer> inorderTraversalMy2(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while ( !s.empty() || current != null){
            while (current!=null){
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            integers.add(current.val);
            current = current.right;
        }
        return integers;
    }
}
```
##### 3. 后序遍历
    迭代算法后序遍历 宽度优先:
    从根节点开始，每次迭代弹出当前栈顶元素，将栈顶元素值添加值 List 第一个位置。 并将其孩子节点压入栈中，先压左孩子再压右孩子
    
```java
class Traversal{
    public List<Integer> postTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        if(root == null) return integers;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            integers.addFirst(root.val);
            if (root.left != null) stack.add(root.left);
            if (root.right != null) stack.add(root.right);
        }
        return integers;
    }
}
```