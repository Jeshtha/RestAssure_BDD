Feature: Get book by q
  Scenario: User calls web service to get a book for query
	Given a book exists with q of "Boston"
	When a user retrieves the book by q
	Then the status code is 200
	