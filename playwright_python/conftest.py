import json

# Global results list
bdd_results = []

def pytest_sessionfinish(session, exitstatus):
    """Write JSON results at the end of the session, overwriting each run"""
    with open("bdd_results.json", "w", encoding="utf-8") as f:
        json.dump(bdd_results, f, indent=2, ensure_ascii=False)