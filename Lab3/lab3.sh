#!/bin/zsh
# Kill process using port 8080
PORT=8080
PID=$(lsof -ti tcp:$PORT)
if [ -n "$PID" ]; then
  echo "Đang kill tiến trình chiếm port $PORT: $PID"
  kill -9 $PID
else
  echo "Không có tiến trình nào chiếm port $PORT."
fi

# Chạy ứng dụng Spring Boot Lab3
cd "$(dirname "$0")"
echo "Đang chạy Lab3 Spring Boot trên port $PORT..."
./mvnw spring-boot:run &

# Đợi vài giây cho server khởi động (có thể chỉnh lại nếu cần)
sleep 5

# Tự động mở trình duyệt web
open "http://localhost:8080"
