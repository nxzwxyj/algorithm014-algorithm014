学习笔记

# `泛型递归`、树的递归

### 树的面试题的解法为什么一般都是递归？

#### 1.结点的定义

树的数据结构和结点的定义都是以递归形式进行的

树的节点都是父节点和子节点构成，子节点也可以作为下一棵树的父节点，以此类推



#### 2.重复性（自相似性）

树的数据结构定义和算法特性都是有重复性的（也可以说是自相似性）

一棵大树都是由一颗颗小树构成的

##### 比如：二叉搜索树

它的左子树的结点**都要小于**根节点，右子树的结点**都要大于**根节点，且左右子树具有相似的特征（满足以上特征）

**注意：**都要小于是指不仅是根相邻的儿子结点要小于或者大于根节点，而是根节点的整个儿子结点都要小于或者都要大于根节点



#### 前序遍历

以根节点->左儿子结点->右儿子结点的方式遍历整个树的结构

`def preorder(self, root):`

`if root:`

​	`self.traverse_path.append(root.val)`

​	`self.preorder(root.left)`

​	`self.preorder(root.right)`



#### 中序遍历

以左儿子结点->根结点->右儿子结点的方式遍历整个树的结构

`def inorder(self, root):`

`if root:`

​	`self.inorder(root.left)`

​	`self.traverse_path.append(root.val)`

​	`self.inorder(root.right)`



#### 后序遍历

以左儿子结点->根节点->右儿子结点的方式遍历整个树的结构

`def postorder(self, root):`

`if root:`

​	`self.postorder(root.left)`

​	`self.postorder(root.right)`

​	`self.traverse_path.append(root.val)`

**总结**：怎样记住区分各种遍历及记住遍历的顺序？

根结点在那个位置，就是什么遍历（比如：前序遍历，跟结点在前面；中序遍历，跟结点在中间；后序遍历，根节结点在后面）

左节点永远是在有节点的前面

前序遍历，中序遍历，后序遍历都是一个递归的过程



#### 递归 Recursion

递归-循环（递归类似于循环，递归通过循环体来调用自己的一个循环）

通过函数体来进行的循环



##### 类似于我们从小都听过的故事：

1.从前有座山

2.山上有个庙

3.庙里有个小和尚

4.返回1



##### 电影《盗梦空间》的故事情节类似于递归：

![image-20200824205945680](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200824205945680.png)



##### 计算n!

n! = 1 * 2 * 3 * ... * n

`def Factorial(n):`

​	`if n <= 1:`

​		`return 1`

​	`return n * Factorial(n - 1)`

运行方式：递归栈（剥洋葱）

![image-20200824210701734](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200824210701734.png)



##### Python代码模板

`def recursion(level, param1, param2,...);`

​	`#recursion terminator`

​	`if level > MAX_LEVEL:`

​		`process_result`

​		`return`

​	`#process logic in current level`

​	`process(level, data...)`

​	`#drill down`

​	`self.recursion(level + 1, p1, ...)`

​	`#reverse the current level status if needed`

##### 代码分解

第一部分：#recursion terminator递归终结条件

写递归函数一定要先把递归终止条件写上，避免无限循环或者死循环

第二部分：#process login in current level处理当前层逻辑

写业务逻辑代码

第三部分：#drill down下探到下一层

参数用来标记是哪一层level + 1,参数p1,p2...写上

第四部分：#清理当前层

可有可无，当有一些全局变量时，可以进行清理、



##### Java代码模板

`public void recur(int level, int param){`

​	`//terminator`

​	`if (level > MAX_LEVEL) {`

​	`//process result`

​	`return;`

​	`}`

​	`//process current logic`

​	`process(level, param);`

​	`//drill down`

​	`recur(level : level + 1, newParam);`

​	`//restore current status`

`}`



##### 思维要点

1.不要人肉进行人肉递归（最大误区）

人肉递归就是画出递归所进行的状态（递归的状态树）

2.找到最近最简方法，将其拆解成可重复解决的问题（最近重复子问题）

程序代码只有if{}else{},while(){loop},递归三种问题

3.数学归纳法思维

就是n=1,n=2成立时且能证明n成立的情况下推导出n+1也是成立的



## 分治、回溯的实现和特性



分治和递归本质上就是递归，是递归的一个细分类（本质上都是在找重复性，最近重复性或者是最优重复性）

### 分治（Divide & Conquer）

分治算法的思想就是将一个大的比较复杂难以解决的问题（可通过重复计算解决）分解成多个小的比较容易解决的子问题，最后将子问题求解的结果合并到一块进行处理就是这个大问题的结果。

比如：斐波那契数列问题、爬楼梯问题、抛硬币问题都可以使用分治算法很好的解决

![image-20200829102728930](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200829102728930.png)

#### 分治算法解决问题的过程

![image-20200829103603077](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200829103603077.png)

#### 分治代码模板

`def divide_conquer(problem, param1, param2, ...) :`

​	`#recursion terminator`

​	`if problem is None:`

​		`print_result`

​		`return`

​	`#prepare data`

​	`data = prepare_data(problem)`

​	`subproblems = split_problem(problem, data)`

​	`#conquer subproblems`

​	`subresult1 = self.divide_conquer(subproblems[0], p1, ...)`

​	`subresult2 = self.divide_conquer(subproblems[1], p1, ...)`

​	`subresult3 = self.divide_conquer(subproblems[2], p1, ...)`

​	`...`

​	`#process and generate the final result`

​	`result = process_result(subresult1, subresult2, subresult3, ...)`

``#revert the current level states`



### 回溯（BackTracking）

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分布答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其他的可能的分布解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

​	1.找到一个可能存在的正确的答案；

​	2.在尝试了所有可能的分步方法或宣告该问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

比如八皇后问题、数独问题可以使用回溯算法进行很好的解决





























