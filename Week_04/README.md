学习笔记

## 深度优先搜索和广度优先搜索

### 搜索

一般都是暴力搜索，树或者图的每个节点都遍历一次

如果遍历的数据结构没有任何特点，就遍历所有的节点，同时保证**每个节点访问一次，且仅访问一次**，最终搜索到我们想要的节点



### 遍历搜索

树的搜索方式，先是访问根节点，然后搜索左子树，一个一个节点的搜索，当搜索完左子树，然后开始搜索右子树，直到找到我们所需要的那个节点

![image-20200904214057232](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200904214057232.png)

#### 树的定义（示例代码）

##### Python

```python
class TreeNode:
    def_init_(self, val):
        self.val = val
        self.left, self.right = None, None
```



##### Java

```java
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```



##### C++

```c++
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x):val(x), left(NULL), right(NULL){}
}
```



#### 搜索-遍历

每个节点都要访问一次

每个节点仅仅要访问一次（在搜索中，不要做过多无用的访问，降低访问效率）

对于节点的访问顺序不同

​	深度优先：depth first search

​	广度优先：breadth first search

​	优先级优先又叫**启发式搜索**（适用于现实的业务场景，可以根据应用场景进行设计不同的优先级）



#### 深度优先搜索(Depth-First-Search)

##### 实例代码(二叉树)

```python
def dfs(node):
    if node in visited:
        #already visited
        return
    visited.add(node)
    
    #process current node
    #...#logic here
    dfs(node.left)
    dfs(node.right)
```



##### DFS代码 - 递归写法(多叉树)

```python
visited = set()
def dfs(node, visited):
    visited.add(node)
    #process current node here
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited);
```



#### 二叉树遍历顺序

![image-20200904220716819](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200904220716819.png)



#### 图的遍历顺序

![image-20200904221118088](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200904221118088.png)



#### 代码优化(DFS代码 - 递归写法)

在最开始的时候就检查node是否被访问过

```python
visited = set()

def dfs(node, visited):
    if node in visited: #terminator
        #already visited
        return
    
    visited.add(node)
    #process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next node, visited)
```



#### DFS代码 - 非递归写法

```python
def DFS(self, tree):
    if tree.root is None:
        return []
    
    visited, stack = [], [tree.root]
    
    while stack:
        node = stack.pop()
        visited.add(node)
        
        process (node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
        
    # other processing work
    ...
```



#### 实例代码（Java）

```java
public List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> allResults = new ArrayList<>();
    if(root == null){
        return allResults;
    }
    travel(root, 0, allResults);
    return allResults;
}

private void travel(TreeNode root, int level, List<List<Integer>> results){
    if(results.size() == level){
        results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if(root.left != null){
        travel(root.left, level + 1, results);
    }
    if(root.right != null){
        travel(root.right, level + 1, results);
    }
}
```



### 广度优先搜索（Breadth-First-Search）

**不用递归，不用栈，而是使用队列**



#### 二叉树遍历顺序

![image-20200904222827898](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200904222827898.png)



#### 广度优先遍历和深度优先遍历遍历顺序的区别

![image-20200904223043976](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200904223043976.png)



#### BFS代码

```python
def BFS(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)
    
    while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
        
    # other processing work
    ...
```

BFS就是使用一个队列来表示，其实就是一个数组，在Java语言中，可能更多使用一个链表或者是一个双端队列就是deque表示



#### 实例代码

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x){
        val = x;
    }
}

public List<List<Integer>> leveelOrder(TreeNode root){
    List<List<Integer>> allResults = new ArrayList<>();
    if(root == null){
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while(!nodes.isEmpty()){
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++){
            TreeNode node = nodes.poll();
            results.add(node.val);
            if（node.left != null）{
                nodes.add(node.left);
            }
            if(node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```



# 贪心算法Greedy

贪心算法是一种在每一步选择中都采取在当前状态下最好或者最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。**然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案（如果每次只考虑局部最优解的话，最终结果不一定可以达不到最优解的，所以贪心算法需要满足一些前置条件才可以使用的）。**

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。**由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。**



## 贪心算法和动态规划的区别

贪心算法与动态规划的不同在于它**对每个子问题的解决方案都做出选择，不能回退**。

动态规划**会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能**。

**贪心：当下做局部最优判断**

**回溯：能够回退**

**动态规划：最优判断 + 回退**



### 实战题目

#### 贪心法的正例

![image-20200906090158348](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906090158348.png)

这个题目是适合使用贪心算法来解决的，Coins数组中前一个值总是后一个值的倍数（贪心法的特殊性，这个硬币的值是有整除关系的）

首先用最大的Coin值来匹配，看最大的Coin值最多可以匹配几个，然后用total - Coin值*该Coin值匹配的个数，最后一次让后面的Coin值按以上方法进行匹配（先用最大的Coin值去匹配，然后用次大的再去匹配，直道满足total=0）

![image-20200906090830884](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906090830884.png)

#### 贪心法的反例

![image-20200906091359524](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906091359524.png)

![image-20200906091547473](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906091547473.png)

用贪心算法的前提：

**1.问题比较特殊**

**2.该问题用简答粗暴的贪心算法得到最优解的**



### 适用贪心算法的场景

简单的说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。



### 用贪心法的难点

1.证明该问题怎样可以用贪心法得到最优解

2.贪心法的角度不同（有些时候可以正常使用贪心算法，有些时候需要将问题稍微转化一下，再进行所谓的贪心求解）

3.贪心法的方法：

​	从前往后贪进行求解（常规套路）

​	从后往前贪进行求解



# 二分查找（关键是化繁为简）

## 二分查找的前提

1.目标函数单调性（单调递增或者单调递减）（原始数据必须是有序排列的，如果是无序的话就没有办法进行二分查找，正是因为原始数据是有序，才能通过判断它的某些特征排除掉前半部分或者是后半部分，从而可以降低查找的时间复杂度（从O(n) -> O(logn)））

2.存在上下界（bounded）（如果没有上下界的话，它的空间可能是无穷大的，没有办法往中间扩）

3.能够通过索引（下标）访问（index accessible）（可以索引访问，最好是数组，可以通过数组下标进行访问。如果是单链表的话，即使是有序的，单链表进行二分查找都不是那么容易的，可以将单链表进行优化，使用跳表的方式）



### 代码模板

```python
left, right = 0, len(array) - 1
while left <= right:
    mid = （left + right）/ 2
    if array[mid] == target:
        #find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```



### 示例

![image-20200906104632295](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906104632295.png)

![image-20200906104918905](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906104918905.png

![image-20200906105011713](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906105011713.png)

![image-20200906105037641](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200906105037641.png)

过程：

它是由左右两个边界不断地向中间进行夹逼的过程，这种夹逼的过程又由于这个数组本身它是单调递增的，所以我们每次可以排除一半，有点像二叉搜索树一样的特性，但是这里的话它是用所谓的数组来进行实现的。 

