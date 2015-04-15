
class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {

            }

            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
        defaultTextForConsolePlugin(controller: 'console', action: '*') {
            before = {
                def defaultCode = grailsApplication.config.console.defaultCode
                println "@@@@@@@@@@@@@@@@@@@@@"
                if (!session['_grails_console_last_code_'] && defaultCode) {
                    session['_grails_console_last_code_'] = defaultCode
                }
            }
        }
    }
}
