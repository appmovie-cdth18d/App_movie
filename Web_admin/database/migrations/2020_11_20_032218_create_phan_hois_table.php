<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePhanHoisTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('phanhoi', function (Blueprint $table) {
            $table->increments('id');
            $table->text('Noidung');
            $table->integer('taikhoan_id')->unsigned()->index();
            $table->integer('binhluan_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('binhluan_id')->references('id')->on('binhluan');
            $table->foreign('taikhoan_id')->references('id')->on('taikhoan');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phanhoi');
    }
}
