SELECT 
    transdate,
    description,
    symbol,
    quantity,
    price AS 'PPS'
FROM
    financial.security_transactions
LIMIT 1000;