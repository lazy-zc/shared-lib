def call(String apiUrl, String jobName, String jobStatus) {
    
    def payload = """
    {
      "msg_type": "interactive",
      "card": {
        "config": {
          "wide_screen_mode": true
        },
        "header": {
          "title": {
            "tag": "plain_text",
            "content": "⚠️ Jenkins Job Alert"
          }
        },
        "elements": [
          {
            "tag": "div",
            "text": {
              "tag": "lark_md",
              "content": "Jenkins job '${jobName}' : ${jobStatus}."
            }
          }
        ]
      }
    }
    """
    
    try {
        def response = httpRequest(
            url: apiUrl,
            httpMode: 'POST',
            contentType: 'APPLICATION_JSON_UTF8',
            requestBody: payload,
            quiet: true
        )
        
    } catch (Exception e) {
        echo "Failed to send alarm to Lark API: ${e.message}"
    }
}
