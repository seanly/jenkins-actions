#!/usr/bin/env groovy

def call(repoWithBranch) {
    if (!repoWithBranch) {
        return
    }
    // 解析 repo 和 branch
    def (repo, branch) = repoWithBranch.tokenize('@')
    if (!branch) {
        branch = 'main'
    }
    if (!repo.startsWith('http')) {
        repo = "https://${repo}"
    }

    def clonePath = ".pipeline"
    def actionsPath = "actions"

    checkout changelog: false, poll: false,
        scm: [
            $class: 'GitSCM',
            branches: [[name: branch]],
            extensions: [
                [$class: 'CleanBeforeCheckout', deleteUntrackedNestedRepositories: true],
                [$class: 'RelativeTargetDirectory', relativeTargetDir: clonePath],
                [$class: 'CloneOption', depth: 1, noTags: true, reference: '', shallow: true],
                [$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: actionsPath]]]
            ],
            userRemoteConfigs: [[
                url: repo
            ]]
        ]

    fileOperations([
        fileCopyOperation(
            sourceFiles: "${clonePath}/${actionsPath}",
            targetLocation: '.actions'
        ),
        fileDeleteOperation(includeFilePattern: "${clonePath}/**/*")
    ])
} 