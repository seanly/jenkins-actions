# Jenkins Actions Shared Library

这是一个 Jenkins Shared Library，用于从 Git 仓库下载 actions 目录并重命名为 `.actions`。

## 功能特性

- 支持 `github.com/owner/repo@branch` 格式的仓库地址
- 自动解析仓库地址和分支名
- 稀疏检出，只下载 actions 目录
- 自动清理临时文件
- 支持默认分支（main）

## 安装配置

### 1. 在 Jenkins 中配置 Shared Library

1. 进入 Jenkins 管理页面
2. 选择 "Manage Jenkins" > "Configure System"
3. 找到 "Global Pipeline Libraries" 部分
4. 添加新的库配置：
   - **Name**: `jenkins-actions`
   - **Default version**: `main` (或你想要的默认分支)
   - **Source Code Management**: Git
   - **Project Repository**: 你的库仓库地址
   - **Credentials**: 如果需要的话

### 2. 在 Pipeline 中使用

```groovy
@Library('jenkins-actions') _

pipeline {
    agent any
    
    stages {
        stage('Checkout Actions') {
            steps {
                script {
                    // 基本用法
                    checkoutActions('github.com/seanly/jenkins-actions@main')
                    
                    // 使用默认分支
                    checkoutActions('github.com/seanly/jenkins-actions')
                }
            }
        }
    }
}
```

## 使用示例

### 基本用法
```groovy
checkoutActions('github.com/seanly/jenkins-actions@main')
```

### 使用默认分支
```groovy
checkoutActions('github.com/seanly/jenkins-actions')
```

### 使用完整 URL
```groovy
checkoutActions('https://github.com/seanly/jenkins-actions@develop')
```

## 目录结构

```
jenkins-actions/
├── vars/
│   └── checkoutActions.groovy    # 全局函数
├── src/
│   └── org/example/
│       └── Pipeline.groovy       # 高级 API 类
├── Jenkinsfile                   # 示例 Pipeline
└── README.md                     # 说明文档
```

## 注意事项

- 确保目标仓库包含 `actions` 目录
- 函数会自动清理临时克隆的目录
- 下载的 actions 目录会被重命名为 `.actions`
- 支持 HTTPS 和 SSH 协议（需要配置相应的凭据）

## 故障排除

如果遇到问题，请检查：
1. Jenkins Shared Library 配置是否正确
2. 目标仓库是否存在且可访问
3. 仓库中是否包含 `actions` 目录
4. 网络连接是否正常 