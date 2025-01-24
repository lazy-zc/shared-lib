def call(String apiUrl, String jobName, String jobStatus) {
    
    def payload = """
    {
        "msg_type": "text",
        "content": {
            "text": "Jenkins job '${jobName}' has failed with status: ${jobStatus}. Please investigate."
        }
    }
    """
    
    def httpRequest = [
        url: apiUrl,
        httpMode: 'POST',
        contentType: 'APPLICATION_JSON',
        requestBody: payload,
        quiet: true
    ]
    
    // Send the request to Lark
    try {
        httpRequest(httpRequest)
    } catch (Exception e) {
        echo "Failed to send alarm to Lark API: ${e.message}"
    }
}
