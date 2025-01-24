def call(String apiUrl, String jobName, String jobStatus) {
    
    def payload = """
    {
        "msg_type": "text",
        "content": {
            "text": "Jenkins job '${jobName}' has failed with status: ${jobStatus}. Please investigate."
        }
    }
    """
    
    try {
        def response = httpRequest(
            url: apiUrl,
            httpMode: 'POST',
            contentType: 'APPLICATION_JSON',
            requestBody: payload,
            quiet: true
        )
        
    } catch (Exception e) {
        echo "Failed to send alarm to Lark API: ${e.message}"
    }
}
