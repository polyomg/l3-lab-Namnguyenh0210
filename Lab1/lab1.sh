#!/bin/zsh
# Script tự động kill port 8080 và chạy ứng dụng Spring Boot Lab1
# Giải thích: Nếu có tiến trình chiếm port 8080 thì sẽ kill, sau đó khởi động web

PORT=8080
PID=$(lsof -ti tcp:$PORT)
if [ -n "$PID" ]; then
  echo "Đang kill tiến trình chiếm port $PORT: PID $PID"
  kill -9 $PID
else
  echo "Port $PORT đang rảnh, không cần kill."
fi

# Chạy ứng dụng Spring Boot
./lab1.sh./lab1.sh# Chạy ngầm để script tiếp tục mở trình duyệt
./mvnw spring-boot:run &
SPRING_PID=$!

# Đợi ứng dụng khởi động (có thể chỉnh thời gian nếu cần)
sleep 3

# Mở trình duyệt web tới địa chỉ localhost:8080
open http://localhost:8080

# Hiển thị thông báo
echo "Đã mở web tại http://localhost:8080. Nếu chưa lên, hãy kiểm tra log ứng dụng!"
