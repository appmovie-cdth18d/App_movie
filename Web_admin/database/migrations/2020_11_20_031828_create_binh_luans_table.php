<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateBinhLuansTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('binhluan', function (Blueprint $table) {
            $table->increments('id');
            $table->text('Noidung');
            $table->datetime('Ngaydang');
            $table->integer('taikhoan_id')->unsigned()->index();
            $table->integer('phim_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('taikhoan_id')->references('id')->on('taikhoan');
            $table->foreign('phim_id')->references('id')->on('phim');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('binhluan');
    }
}
