SELECT 
    transdate,
    description,
    symbol,
    quantity
FROM
    financial.security_transactions
LIMIT 1000;