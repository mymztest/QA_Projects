from pytest_bdd import scenarios, given, when, then, parsers
from pages.login_page import LoginPage
from conftest import bdd_results  # import the global list
from playwright.sync_api import Page
from playwright.sync_api import sync_playwright


scenarios('../features/login.feature')

import pytest
@pytest.fixture
def login_context():
    with sync_playwright() as p:
        browser = p.chromium.launch(headless=False)  # headless=False opens the UI
        page = browser.new_page()
        context = {"page": LoginPage(page), "username": None, "password": None}
        yield context
        browser.close()
        

@given("I open the login page")
def open_login_page(login_context):
    login_context["page"].load()
    return login_context

@when(parsers.parse('I login with username "{username}" and password "{password}"'))
def login_with_credentials(login_context, username, password):
    login_context["username"] = username
    login_context["password"] = password
    login_context["page"].login(username, password)


@then(parsers.parse('I should see "{expected_result}"'))
def verify_login_result(login_context, expected_result):
    username = login_context.get("username", "unknown")
    password = login_context.get("password", "unknown")
    page = login_context.get("page")

    if expected_result == "Swag Labs":
        result = page.is_logged_in()
    elif expected_result == "Epic sadface: Username and password do not match any user in this service":
        result = page.login_failed()
    
    # Append result BEFORE assert so even failures are logged
    bdd_results.append({
        "username": username,
        "password": password,
        "expected_result": expected_result,
        "passed": result
    })
    
    assert result, f"Login test failed for {username}"
