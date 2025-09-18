from playwright.sync_api import Page

class LoginPage:
    def __init__(self, page: Page):
        self.page = page
        self.username_input = "#user-name"
        self.password_input = "#password"
        self.login_button = "#login-button"
        self.error_message = "[data-test='error']"
        self.home_logo = ".app_logo"
        
    def load(self):
        self.page.goto("https://www.saucedemo.com/")
        self.page.wait_for_timeout(3000)

    def login(self, username: str, password: str):
        self.page.fill(self.username_input, username)
        self.page.fill(self.password_input, password)
        self.page.wait_for_timeout(1000)
        self.page.click(self.login_button)
        #self.page.wait_for_timeout(3000)

    def is_logged_in(self) -> bool:
        return self.page.is_visible(self.home_logo)

    def login_failed(self) -> bool:
        return self.page.is_visible(self.error_message)
