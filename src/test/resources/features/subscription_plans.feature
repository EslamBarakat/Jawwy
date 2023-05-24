Feature: Subscription plans details

  Background: Open website and change language to English
    Given I open website "https://subscribe.stctv.com/"
    And I change language to English

  Scenario Outline: Check all countries subscription details
    Given I open countries menu
    When I choose "<Country>" country
    Then I check mobile subscription is "<Status>"
    And I check types "LITE,CLASSIC,PREMIUM" are displayed
    And I check the price is "<Price>"
    And I check the currency is "<Currency>"

    Examples:
      | Country   | Status   | Price | Currency       |
      | Egypt     | Enabled  | 7.00  | Egyptian pound |
      | Uae       | Enabled  | 10.00 | AED            |
      | Algeria   | Disabled | 2.7   | USD            |
      | Djibouti  | Disabled | 2.4   | USD            |
      | Chad      | Disabled | 2.4   | USD            |
      | Iraq      | Enabled  | 900   | IQ             |
      | Jordan    | Enabled  | 0.99  | JOD            |
      | Lebanon   | Disabled | 2.4   | USD            |
      | Morocco   | Disabled | 2     | USD            |
      | Oman      | Enabled  | 1     | OMR            |
      | Tunisia   | Enabled  | 1     | TND            |
      | Yemen     | Disabled | 2.4   | USD            |
      | Palestine | Disabled | 2.4   | USD            |