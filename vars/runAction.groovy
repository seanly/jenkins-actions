def call(action, args = []) {
    def scriptPath = ".actions/${action}/run.sh"
    if (!fileExists(scriptPath)) {
        error "Action script not found: ${scriptPath}"
    }
    
    // 构建环境变量
    def envVars = args.collect { arg ->
        def (key, value) = arg.tokenize('=')
        return "INPUT_${key.toUpperCase()}=${value}"
    }.join(' ')
    
    sh "chmod +x ${scriptPath}"
    sh "${envVars} ${scriptPath}"
} 