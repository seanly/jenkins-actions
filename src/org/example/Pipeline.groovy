package org.example

class Pipeline implements Serializable {
    def script
    
    Pipeline(script) {
        this.script = script
    }
    
    def checkoutActions(repoWithBranch) {
        script.checkoutActions(repoWithBranch)
    }
    
    def checkoutActionsWithOptions(repoWithBranch, options = [:]) {
        // 可以在这里添加更多选项，比如自定义actions目录名等
        script.checkoutActions(repoWithBranch)
    }
} 