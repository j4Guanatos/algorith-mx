# Algorithms EPAMX

EPAM Mexico Algorithms study group.

### Instructions

* A set of problems, ranked Easy, Medium or Difficult, will be posted every Monday. In average will be two problems.
* As a Developer, you should create your branch from master repository `$ git checkout -b <my-branch-name>`
* You will be using your branch to commit your solutions. After a week we will make a meeting to review the solutions of each of us.
* We will discuss the best solutions and document them in the master branch.
* After this, a new set of problems will be posted. During the meeting we will choose the new set of problems we will discuss.
* If you already know the solutions of the problems, code them and show to the group why you consider yours the best solution.

### Setting up the problems and updating the branch

Each problem will follow the following package convention: `mx.epam.algorithms.<problem-topic>.<problem-package>`. 

Example: `mx.epam.algorithms.warmup.helloworld`.

Inside the problem package folder, on master branch the following files will be placed:

* A markdown file (.md) containing the problem instructions, called README.md.
* A set of .in and .out files, containing sample test cases.

To update the branch, with the new problems, use: `$ git rebase -p origin/master`

### Programming Languages

We are using java package convention, but you can use any programming language you want. Only be careful to preserve your branch organized and commit your solutions in the proper folder/package.